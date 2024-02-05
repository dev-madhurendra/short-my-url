import { Typography } from "@mui/material";
import { TYPOGRAPHY_DATATESTID } from "../../../utils/constants";
import { CustomTypographyProps } from "../../../utils/interfaces";

const MuiTypography = ({ variant, sx, text, ...rest }: CustomTypographyProps) => (
  <Typography data-testid={TYPOGRAPHY_DATATESTID} variant={variant} sx={sx} {...rest}>
    {text}
  </Typography>
);

export default MuiTypography;
